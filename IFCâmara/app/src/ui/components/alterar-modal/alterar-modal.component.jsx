import "./alterar-modal.style.css"
import { Modal, BotaoPrincipal } from ".."
import { useEffect } from "react";
import { useForm } from "../../../hook/form/use-form.hook";
import { useAlterarEvento } from "../../../hook/api/eventos/use-alterar-evento.hook"

export function AlterarModal({id, evento, isOpen, setIsOpen, fetchEventos}) {
    const { alterarEvento } = useAlterarEvento();
    const { formData, handleChange, setFormData } = useForm({evento: ""});

    useEffect(()=> {
        setFormData({evento: evento.descricaoTipo});
    },[])

    async function handleAlterar() {
        await alterarEvento(id, evento.id, formData.evento);
        await fetchEventos(id);
        setIsOpen(false);
    }

    return (
        <Modal isOpen={isOpen} setIsOpen={setIsOpen}>
            <div className="alterar-modal">
                <h1>Alterar Evento</h1>
                <form onSubmit={handleAlterar}>
                    <input type="text" value={formData.evento} name="evento" onChange={handleChange}/>
                    <BotaoPrincipal texto={"Alterar"} onClick={handleAlterar}/>
                </form>
            </div>
        </Modal>
    )

}
import "./inscrever-modal.style.css"
import { Modal, BotaoPrincipal } from "../../components"
import { useListarEventos } from "../../../hook/api/eventos/use-listar-eventos.hook"
import { useEffect } from "react";
import { useForm } from "../../../hook/form/use-form.hook";
import { useInscreverEvento } from "../../../hook/api/eventos/use-inscrever-evento.hook"

export function InscreverModal({id, isOpen, setIsOpen, fetchEventos}) {
    const { eventos, listarEventos } = useListarEventos();
    const { inscreverEvento } = useInscreverEvento();
    const { formData, handleChange, setFormData } = useForm({evento: {}});

    useEffect(()=> {
        const eventos = listarEventos();
        setFormData(eventos[0]);
    },[])

    async function handleInscrever() {
        await inscreverEvento(id, formData.evento);
        await fetchEventos(id);
        setIsOpen(false);
    }

    return (
        <Modal isOpen={isOpen} setIsOpen={setIsOpen}>
            <div className="inscrever-modal">
                <h1>Inscrever Evento</h1>
                <form onSubmit={handleInscrever}>
                    <select name="evento" onChange={handleChange}>
                        {eventos ? eventos.map(evento=> {
                            return (
                                <option key={evento.id} value={evento.id}> {evento.descricaoTipo}</option>
                                )
                            }):null}
                    </select>
                    <BotaoPrincipal texto={"Inscrever"} onClick={handleInscrever}/>
                </form>
            </div>
        </Modal>
    )

}
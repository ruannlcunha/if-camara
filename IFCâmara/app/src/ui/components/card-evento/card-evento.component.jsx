import { useState } from "react";
import { useRemoverEvento } from "../../../hook/api/eventos/use-remover-evento.hook"
import { AlterarModal } from "../index"
import "./card-evento.style.css"

export function CardEvento({id, evento, fetch}) {
    const { removerEvento } = useRemoverEvento();
    const [alterarIsOpen, setAlterarIsOpen] = useState(false);

    async function handleRemover() {
        await removerEvento(id, evento.id);
        await fetch(id);
    }

    return (
            <div className="evento">
                <h1>{evento.descricaoTipo}</h1>
                <section>
                    <button className="editar-evento" onClick={()=>setAlterarIsOpen(true)}></button>
                    <button className="remover-evento" onClick={handleRemover}></button>
                </section>
            <AlterarModal id={id} evento={evento} setIsOpen={setAlterarIsOpen} isOpen={alterarIsOpen} fetchEventos={fetch}/>
            </div>
    )
}
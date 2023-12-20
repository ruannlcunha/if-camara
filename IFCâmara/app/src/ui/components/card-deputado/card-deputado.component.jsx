import "./card-deputado.style.css"
import {BotaoPrincipal} from "../index"
import { useNavigate } from "react-router-dom"

export function CardDeputado({deputado}) {
    const navigate = useNavigate();

    return (
        <div className="card-deputado">
            <header><div className="deputado-foto" style={{backgroundImage: `url(${deputado.urlFoto})`}}></div></header>
            <h1>{deputado.nome}</h1>
            <p>Deputado membro do partido <strong>{deputado.siglaPartido}</strong>, 
            do Estado de <strong>{deputado.siglaUf}</strong></p>
            <BotaoPrincipal texto={"Ver Deputado"} onClick={()=>navigate(`/deputados/${deputado.id}`)}/>
        </div>
    )
}
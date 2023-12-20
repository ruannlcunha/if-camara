import "./deputado.style.css"
import { HeaderComponent, ContainerScreen, BotaoPrincipal, CardEvento, InscreverModal } from "../../components"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import { useVisualizarDeputado } from "../../../hook/api/deputados/use-visualizar-deputado.hook"
import { useListarEventosPorDeputado } from "../../../hook/api/eventos/use-listar-eventos-por-deputado.hook"

export function DeputadoScreen() {
    const { deputado, visualizarDeputado } = useVisualizarDeputado();
    const { eventos, listarEventosPorDeputado } = useListarEventosPorDeputado();
    const [inscreverModalIsOn, setInscreverModalIsOn] = useState(false);
    const { id } = useParams();

    useEffect(()=> {
        visualizarDeputado(id);
        listarEventosPorDeputado(id);
    },[])

    return (
    <ContainerScreen>
            <HeaderComponent />
            <div className="deputado-container">
                <section className="deputado-perfil">
                    <div className="perfil-foto" style={{backgroundImage: `url(${deputado.urlFoto})`}}></div>
                    <h1>{deputado? deputado.nome:null}</h1>
                    <p>Deputado membro do partido <strong>{deputado? deputado.siglaPartido:null}</strong>, 
                    do Estado de <strong>{deputado? deputado.siglaUf:null}</strong></p>
                    <BotaoPrincipal texto={"Inscrever Evento"} onClick={()=>setInscreverModalIsOn(true)}/>
                </section>
                <section className="deputado-eventos">
                    <h1>Lista de Eventos Inscritos</h1>
                    {eventos? eventos.map(evento=> {
                        return (
                            <CardEvento key={evento.id} id={id} evento={evento} fetch={listarEventosPorDeputado}/>
                        )
                    }):null}
                </section>
            </div>
            <InscreverModal id={id} fetchEventos={listarEventosPorDeputado} isOpen={inscreverModalIsOn} setIsOpen={setInscreverModalIsOn}/>
        </ContainerScreen>
    )
}
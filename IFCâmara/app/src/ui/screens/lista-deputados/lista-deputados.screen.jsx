import "./lista-deputados.style.css"
import { useListarDeputados } from "../../../hook/api/deputados/use-listar-deputados.hook"
import { useEffect } from "react"
import { ContainerScreen, HeaderComponent, CardDeputado} from "../../components"

export function ListaDeputadosScreen() {
    const { deputados, listarDeputados } = useListarDeputados();

    useEffect(()=> {
        listarDeputados()
    },[])

    return (
        <ContainerScreen>
            <HeaderComponent />
            <h1 className="lista-deputados-titulo">LISTA DE DEPUTADOS</h1>
            <section className="lista-deputados">
                {deputados ? deputados.map(dep=> {
                    return (
                        <CardDeputado deputado={dep}/>
                        )
                    }) :null}
            </section>
        </ContainerScreen>
    )

}
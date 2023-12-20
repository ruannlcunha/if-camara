import "./home.style.css"
import { HeaderComponent, ContainerScreen, BotaoPrincipal } from "../../components"
import candidato from "../../../assets/img/candidato.png"
import { useNavigate } from "react-router-dom"

export function HomeScreen() {
    const navigate = useNavigate();

    return (
        <ContainerScreen>
            <HeaderComponent />
            <div className="home-container">
                <section>
                <p>{"Bem vindo ao IFCâmara! A plataforma para você visualizar seus deputados favoritos! (ou não)"}</p>
                <BotaoPrincipal texto={"Ver Deputados"} onClick={()=>navigate("/deputados")}/>
                </section>
                <img src={candidato} alt="Imagem de Candidato Desenhado" />
            </div>
        </ContainerScreen>
    )
}
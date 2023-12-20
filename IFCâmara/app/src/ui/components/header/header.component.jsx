import "./header.style.css"
import tituloImage from "../../../assets/img/titulo.png"
import { Link, useNavigate } from "react-router-dom"

export function HeaderComponent() {
    const navigate = useNavigate();

    return (
        <header className="header-container">
            <Link to={"/"}>
            <   img src={tituloImage} alt="Logo do IF Câmara" />
            </Link>
            <label onClick={()=>navigate("/deputados")}>VER DEPUTADOS</label>
        </header>
    )
}
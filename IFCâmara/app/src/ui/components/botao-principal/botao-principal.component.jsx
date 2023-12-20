import "./botao-principal.style.css"

export function BotaoPrincipal({texto, onClick}) {

    return (
        <button className="botao-principal" onClick={onClick}>
                {texto}
                <div></div>
        </button>
    )

}
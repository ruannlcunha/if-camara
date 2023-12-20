import "./transition.style.css"
import { useEffect, useState } from "react";

export function TransitionComponent() {
    const [active, setActive] = useState(true);

    useEffect(()=> {
        setTimeout(handleTimeout, 1500 )
    },[])

    function handleTimeout() {
        setActive(false)
    }

    function renderTransition() {
        return active ? (
        <div className="transition"></div>
        ) : null
    }

    return (
        renderTransition()
    )
}
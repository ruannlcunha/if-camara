import "./container-screen.style.css"
import { TransitionComponent } from "../index"

export function ContainerScreen({children}) {
    return (
        <div className="container-screen">
            {children}
            <TransitionComponent />
        </div>
    )
}
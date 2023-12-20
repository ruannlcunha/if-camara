import { createBrowserRouter } from "react-router-dom";
import { HomeScreen, ListaDeputadosScreen, DeputadoScreen } from "../ui/screens";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <HomeScreen/>,
  },
  {
    path: "/deputados",
    element: <ListaDeputadosScreen/>,
  },
  {
    path: "/deputados/:id",
    element: <DeputadoScreen />,
  }
]);

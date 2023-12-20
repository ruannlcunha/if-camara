import { useState } from "react";
import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useVisualizarDeputado() {
    const [deputado, setDeputado] = useState([])
    const { toastError } = useToast();

    async function _visualizarDeputado(id) {
        const response = await axiosInstance.get(
        `/deputados/${id}`,
        );
        return response.data;
    }

    async function visualizarDeputado(id) {
        try {
            const _deputado = await _visualizarDeputado(id)
            setDeputado(_deputado)
        } catch (error) {
            toastError(error)
        }
    }

    return { deputado, setDeputado, visualizarDeputado };
}

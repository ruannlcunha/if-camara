import { useState } from "react";
import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarEventosPorDeputado() {
    const [eventos, setEventos] = useState([])
    const { toastError } = useToast();

    async function _listarEventosPorDeputado(id) {
        const response = await axiosInstance.get(
        `/eventos/${id}`,
        );
        return response.data;
    }

    async function listarEventosPorDeputado(id) {
        try {
            const _eventos = await _listarEventosPorDeputado(id)
            setEventos(_eventos)
        } catch (error) {
            toastError(error)
        }
    }

    return { eventos, setEventos, listarEventosPorDeputado };
}

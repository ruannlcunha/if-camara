import { useState } from "react";
import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarEventos() {
    const [eventos, setEventos] = useState([])
    const { toastError } = useToast();

    async function _listarEventos() {
        const response = await axiosInstance.get(
        "/eventos",
        );
        return response.data;
    }

    async function listarEventos() {
        try {
            const _eventos = await _listarEventos()
            setEventos(_eventos)
        } catch (error) {
            toastError(error)
        }
    }

    return { eventos, setEventos, listarEventos };
}

import { useState } from "react";
import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarDeputados() {
    const [deputados, setDeputados] = useState([])
    const { toastError } = useToast();

    async function _listarDeputados() {
        const response = await axiosInstance.get(
        "/deputados",
        );
        return response.data;
    }

    async function listarDeputados() {
        try {
            const _Deputados = await _listarDeputados()
            setDeputados(_Deputados)
        } catch (error) {
            toastError(error)
        }
    }

    return { deputados, setDeputados, listarDeputados };
}

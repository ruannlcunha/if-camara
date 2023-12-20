import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useRemoverEvento() {
    const { toastError,toastSuccess  } = useToast();

    async function _removerEvento(deputadoId, eventoId) {
        const response = await axiosInstance.delete(
        `/eventos/${deputadoId}/remover/${eventoId}`
        );
        return response.data;
    }

    async function removerEvento(deputadoId, eventoId) {
        try {
            await _removerEvento(deputadoId, eventoId)
            toastSuccess("Evento Removido")
        } catch (error) {
            toastError(error)
        }
    }

    return { removerEvento };
}

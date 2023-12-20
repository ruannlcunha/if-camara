import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useInscreverEvento() {
    const { toastError,toastSuccess  } = useToast();

    async function _inscreverEvento(id, eventoId) {
        const response = await axiosInstance.post(
        `/eventos/${id}`,
        {
            eventoId
        }
        );
        return response.data;
    }

    async function inscreverEvento(id, eventoId) {
        try {
            await _inscreverEvento(id, eventoId)
            toastSuccess("Evento Inscrito")
        } catch (error) {
            toastError(error)
        }
    }

    return { inscreverEvento };
}

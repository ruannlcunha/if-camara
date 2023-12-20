import { axiosInstance } from "../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useAlterarEvento() {
    const { toastError,toastSuccess  } = useToast();

    async function _alterarEvento(id, eventoId, descricao) {
        const response = await axiosInstance.put(
        `/eventos/${id}`,
        {
            eventoId, descricao
        }
        );
        return response.data;
    }

    async function alterarEvento(id, eventoId, descricao) {
        try {
            await _alterarEvento(id, eventoId, descricao)
            toastSuccess("Evento Alterado")
        } catch (error) {
            toastError(error)
        }
    }

    return { alterarEvento };
}

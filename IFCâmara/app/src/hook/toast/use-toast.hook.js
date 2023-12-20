import { toast } from 'react-toastify';

export function useToast() {

    function toastSuccess(message) {
        toast.success(message , {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
            });
            console.log("TOAST")
    }

    function toastWarning(error) {
        let errorMessage = error;
        if(error.response) errorMessage = error.response.data.message;

        toast.warn(errorMessage , {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
            });
    }

    function toastError(error) {
        if(error.response.data) {
            toast.error(error.response.data.message , {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
                });

            return 
        }
        else {
            toast.error("Ocorreu um erro." , {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
                });
        }
        
    }


    return { toastSuccess, toastWarning, toastError }

}
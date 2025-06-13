import toast from "react-hot-toast";
import keycloak from "./keycloak";
import { createContext , useContext , useState , useEffect} from "react";


//creating auth context
const AuthContext = createContext();

//creating auth provider

export const AuthProvider = ({children}) => {
    const [isAuthenticated,setIsAuthenticated] = useState(false);
    const [keyCloakObject , setKeyCloakObject] = useState(null);
    //onComponent initialization
    useEffect(() => {
        keycloak.init({
            onLoad : 'login-required',
        })
        .then((authenticated) => {
            console.log(authenticated);
            setIsAuthenticated(authenticated);
            setKeyCloakObject(keyCloakObject);
            toast.success("LoggedIn success")
        })
        .catch((error) => {
            toast.error("Login Failed")
            console.log(error);
        });
    } , [])

    return <AuthContext.Provider
        value={{
            isAuthenticated : isAuthenticated,
        }}
    >
        {children}
    </AuthContext.Provider>
}; 

export const useAuth = () => useContext(AuthContext);
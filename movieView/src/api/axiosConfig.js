import axios from "axios";

export default axios.create({
    baseURL:'http://20070809.xyz:8080',
    headers: {"ngrok-skip-browser-warning": "true"}
})

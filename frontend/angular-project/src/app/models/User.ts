export interface User {
    id?: number;
    username: string;
    password: string;
    userType: string;
    email: string;
    mobile: string;
    isdCode: string;
    confirmed: boolean;
}
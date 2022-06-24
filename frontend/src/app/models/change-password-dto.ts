export class ChangePasswordDTO {

    password!: string;
    confirmPassword!: string;
    forgotPassword!: string;

    constructor(password: string, confirmPassword: string, forgotPassword: string) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.forgotPassword = forgotPassword;
    }
}

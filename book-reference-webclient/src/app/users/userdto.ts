import { BookDTO } from '../books/bookdto';
export class UserDTO {
    public fullName: string;

    public login: string;

    public password: string;

    public email: string;

    public sex?: string;

    public dateOfRegistration?: Date;

    public books?: BookDTO[];
}

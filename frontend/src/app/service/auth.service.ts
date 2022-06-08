import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDto } from '../models/jwt-dto';
import { Login } from '../models/login';
import { Nuevo } from '../models/nuevo';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

authURL = 'http://localhost:8080/auth/';

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevo: Nuevo): Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'nuevo', nuevo);
  }

  public login(login: Login): Observable<JwtDto> {
    return this.httpClient.post<JwtDto>(this.authURL + 'login', login);
  }
}

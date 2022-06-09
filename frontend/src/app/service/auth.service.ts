import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JwtDto } from '../models/jwt-dto';
import { Login } from '../models/login';
import { Nuevo } from '../models/nuevo';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = environment.authURL;

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevo: Nuevo): Observable<any> {
    return this.httpClient.post<any>(this.authURL + 'nuevo', nuevo);
  }

  public login(login: Login): Observable<JwtDto> {
    return this.httpClient.post<JwtDto>(this.authURL + 'login', login);
  }

  public refresh(dto:JwtDto): Observable<JwtDto> {
    return this.httpClient.post<JwtDto>(this.authURL + 'refresh', dto);
    // Minuto 09:18
  }
}

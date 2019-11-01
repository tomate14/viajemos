import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { URL_REGISTRO, URL_AUTHENTICATE } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Usuario } from '../../dto/usuario';
import { GenericResponse } from '../../dto/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public _token:String;
  public _usuario:Usuario;

  constructor(private http:HttpClient) { 
    this._token = "";
    this._usuario = null;
  }

  authenticateUser(email:string, password:string):Observable<GenericResponse>{
      let params = new HttpParams();
      params = params.append("username",email);
      params = params.append("password",password);

      return this.http.post<GenericResponse>(URL_AUTHENTICATE, { "username": email, "password": password });
  }

}

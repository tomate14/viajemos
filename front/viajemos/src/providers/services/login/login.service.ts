import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment, URL_LOGIN } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { SocialUser } from 'angular4-social-login';
import { DTOUsuario } from 'src/providers/dto/DTOUsuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  constructor(private http:HttpClient) { }

  getUserLogin(usuario:any):Observable<any>{
    let params = new HttpParams();
    //Usuario de registro comun
    if(usuario.provider == "MANUAL"){
      params = params.append("username",usuario.email);
      params = params.append("password",usuario.password);
      params = params.append("provider",usuario.provider);
    }else{
      //Usuario de registro con algun socialmedia
      //params = params.append("authToken",usuario.authToken);
      params = params.append("username",usuario.email);
      params = params.append("provider",usuario.provider);
      params = params.append("password","");
      //params = params.append("firstName",usuario.firstName);
      //params = params.append("id",usuario.id);
     // params = params.append("lastName",usuario.lastName);
     // params = params.append("name",usuario.name);
      //params = params.append("photoUrl",usuario.photoUrl);
    }
    

    return this.http.get<any>(URL_LOGIN,  { params: params });
    
  }

}


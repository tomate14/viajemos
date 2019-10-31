import { Component } from '@angular/core';
import { AuthService, SocialUser } from "angularx-social-login";
import { FacebookLoginProvider, GoogleLoginProvider } from "angularx-social-login";
import { LoginService } from "../../providers/login.service";
import { Router } from '@angular/router';
import { Usuario } from '../../../dto/usuario';
@Component({
  selector: 'app-login',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage {

  user: SocialUser;
  email:string;
  password:string;
  
  constructor(private authService: AuthService,
              private router: Router,
              private loginService:LoginService) {
    this.user = null;
  }
  
  ngOnInit() {
    this.authService.authState.subscribe((user) => {
      this.user = user;
      if(user != null){
        this.loginService.authenticateUser(user.email, "").subscribe((response)=>{
            console.log(response);  
            this.loginService._usuario = new Usuario();          
            this.loginService._usuario.apellido = response.usuario.apellido;
            this.loginService._usuario.nombre = response.usuario.nombre;
            this.loginService._usuario.email = response.usuario.email;
            this.loginService._usuario.idCiudad = response.usuario.idCiudad;
            this.loginService._usuario.token = response.token;

            this.router.navigateByUrl('/start');
        })
        
      }
      console.log(user);
    });
  }

  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then(x => console.log(x));
  }
 
  signInWithFB(): void {
    this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
  } 
 
  signOut(): void {
    this.authService.signOut();
  }

  signInManual():void{
    this.loginService.authenticateUser(this.email, this.password).subscribe((response)=>{
      console.log(response);  
      this.loginService._usuario = new Usuario();          
      this.loginService._usuario.apellido = response.usuario.apellido;
      this.loginService._usuario.nombre = response.usuario.nombre;
      this.loginService._usuario.email = response.usuario.email;
      this.loginService._usuario.idCiudad = response.usuario.idCiudad;
      this.loginService._usuario.token = response.token;

      this.router.navigateByUrl('/start');
  })
  }
}

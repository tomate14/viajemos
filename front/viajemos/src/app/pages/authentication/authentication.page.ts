import { Component, OnInit } from '@angular/core';
import { GoogleLoginProvider, FacebookLoginProvider, AuthService, SocialUser } from 'angular4-social-login';
import { UserService } from 'src/providers/services/login/user.service';
import { LoginService } from 'src/providers/services/login/login.service';
import { DTOUsuario } from 'src/providers/dto/DTOUsuario';
import { Router } from '@angular/router';


@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.page.html',
  styleUrls: ['./authentication.page.scss'],
})
export class AuthenticationPage implements OnInit {
  ngOnInit(): void {
    //throw new Error("Method not implemented.");
  }

  login = {}
  submitted = false;
  email:string;
  password:string;

  constructor(private authService: AuthService,
              private router: Router, 
              private userService: UserService,
              private loginService: LoginService) {
    this.email = "";
    this.password = "";
  }

  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then((respuesta)=>{
      this.userService.user = respuesta;
      this.router.navigateByUrl('/start');
      //this.navCtrl.setRoot(TabsPage);
    }).catch((error)=>{
      alert("Error login gmail"+error)
    });;
  }

  signInWithFacebook(): void {
    this.authService.signIn(FacebookLoginProvider.PROVIDER_ID).then((respuesta)=>{
      this.userService.user = respuesta;
      this.router.navigateByUrl('/start');
        //this.navCtrl.setRoot(TabsPage);
    }).catch((error)=>{
      alert("Error login face"+error)
    });
  }

  signInManual(){
      let dtouser : DTOUsuario = new DTOUsuario();
      dtouser.email = this.email;
      dtouser.password = this.password;
      dtouser.provider = "MANUAL";
      this.loginService.getUserLogin(dtouser).subscribe(
        (data) => {
          this.userService.user = data;
          this.router.navigateByUrl('/start');
          //Rootear a la pantalla de inicio
        },
        (error) => {         
          throw new Error("No se puede conectar con el Servidor");
        }
      )
    
  }

  signOut(): void {
    this.authService.signOut();
  }

}

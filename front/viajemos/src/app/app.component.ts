import { Component } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { UserService } from 'src/providers/services/login/user.service';
import { AuthService, SocialUser } from 'angular4-social-login';
import { LoginService } from 'src/providers/services/login/login.service';
import { Router } from '@angular/router';
import { MensajeService } from 'src/providers/services/mensajetoast/mensaje.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {
  user:SocialUser;
  
  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar,
    private userService: UserService, 
    private authService: AuthService,
    private loginService:LoginService,
    private mensajeService:MensajeService,
    private router: Router
  ) {
    this.initializeApp();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.authService.authState.subscribe((user) => {
        //this.rootPage = user ? TabsPage:LoginPage;
        if(user != null){
          //identificar al usuario
          this.user =user;
          this.userService.user = user;
          try {
            this.loginService.getUserLogin(this.user).subscribe((respuesta)=>{
              switch(respuesta.code){
                case 200:
                  this.mensajeService.showToast(respuesta.message);
                  this.router.navigateByUrl('/start');
                  //Rootear a la pantalla de inicio
                  break;
                case 202:
                  this.mensajeService.showToast(respuesta.message);
                  //redirigir a la pantalla de tipo de usuario para completar el regitro
                  break;
                default:
                  this.mensajeService.showToast(respuesta.message);
                  break;
              }
             
            })
          } catch (error) {
              this.mensajeService.showToast(error.toString());
          }
          
          //Rootear a la pantalla de inicio
        }

      });
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}

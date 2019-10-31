import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { MenuComponent } from './menu.component';
import { MenuRoutingModule } from './menu-routing.module';


@NgModule({
  declarations: [
          MenuComponent
  ],
  entryComponents: [],
  imports: [FormsModule,
            IonicModule.forRoot(), 
            MenuRoutingModule],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }
    
  ],
  bootstrap: [MenuComponent]
})
export class MenuModule {}

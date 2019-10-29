import { Injectable } from '@angular/core';
import { ToastController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class MensajeService {

  toast: any;
  constructor(public toastController: ToastController) { }

  showToast(mensaje:string) {
    this.toast = this.toastController.create({
      message: mensaje,
      position: 'top',
      duration: 2000
    }).then((toastData)=>{
      //console.log(toastData);
      toastData.present();
    });
  }
  HideToast(){
    this.toast = this.toastController.dismiss();
  }
}

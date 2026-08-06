import { Component } from '@angular/core';
import { Saludo } from '../../saludo';
@Component({
    standalone: true,
  selector: 'app-main-content',
  imports: [],
  templateUrl: './main-content.html',
  styleUrl: './main-content.css'
})
export class MainContent {
    texto_saludo:String = '';
    constructor(private saludoservice:Saludo){
      this.texto_saludo=this.saludoservice.obtenerSaludo('Jose')
    }
}

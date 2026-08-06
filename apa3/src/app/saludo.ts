import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Saludo {
  obtenerSaludo(nombre:string):string{
    return `Hola, ${nombre}!`
  }
}

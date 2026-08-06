import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// 1. Definimos la Interfaz del Producto (estructura de datos)
export interface Product {
  id: number;
  title: string;
  price: number;
  description: string;
  category: string;
  image: string;
  rating: { rate: number, count: number };
}

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  
  private apiUrl = 'https://fakestoreapi.com/products';

  // 2. Inyectamos HttpClient para hacer llamadas a la API
  constructor(private http: HttpClient) { }

  // --- Métodos Requeridos por el Proyecto ---

  /**
   * Obtiene la lista completa de productos
   */
  obtenerTodos(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  /**
   * Obtiene un solo producto por su ID
   */
  obtenerDetalleItem(id: string): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${id}`);
  }

  /**
   * Actualiza un producto
   */
  actualizarItem(id: string, datos: Product): Observable<Product> {
    return this.http.put<Product>(`${this.apiUrl}/${id}`, datos);
  }

  // Nota: buscarPorCriterio no es estándar en esta API.
  // Lo implementaremos como una búsqueda por ID en el componente de búsqueda.
}
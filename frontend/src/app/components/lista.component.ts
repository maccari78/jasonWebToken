import { Component, OnInit } from '@angular/core';
import { Producto } from '../models/producto';
import { ProductoService } from '../service/producto.service';
import { ToastrService } from 'ngx-toastr';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  productos: Producto[] = [];
  roles!: string[];
  isAdmin = false;

  constructor(private productoService: ProductoService, private toastr: ToastrService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.cargar();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if (rol === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    });
  }

  cargar(): void {
    this.productoService.lista().subscribe(
      data => {
        this.productos = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrar(id?: number) {
    this.productoService.delete(id as any).subscribe(
      data => {
        this.toastr.success('Producto eliminado', 'OK', { timeOut: 3000, positionClass: 'toast-top-center' }
        );
        this.cargar();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', { timeOut: 3000, positionClass: 'toast-top-center', }
        )
      }
    );
  }
}

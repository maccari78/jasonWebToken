import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ChangePasswordDTO } from '../models/change-password-dto';
import { ForgotPasswordService } from '../service/forgot-password.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  password!: string;
  confirmPassword!: string;
  forgotPassword!: string;

  dto!: ChangePasswordDTO;

  constructor(
    private forgotPasswordService: ForgotPasswordService,
    private toastrService: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  onChangePassword(): void {
    if (this.password !== this.confirmPassword) {
      this.toastrService.error('Las contraseñas no coiciden', 'FAIL', {
        timeOut: 3000, positionClass: 'toast-top-center'
      });
      return;
    }
    this.forgotPassword = this.activatedRoute.snapshot.params['forgotPassword'];
    this.dto = new ChangePasswordDTO(this.password, this.confirmPassword, this.forgotPassword);
    this.forgotPasswordService.changepassword(this.dto).subscribe(
      data => {
        this.toastrService.success(data.mensaje, 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/login']);
      },
      err => {
        this.toastrService.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
      }
    );
  }

}

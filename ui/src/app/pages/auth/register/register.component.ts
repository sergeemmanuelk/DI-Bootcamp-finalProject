import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/app/environment/dev';
import { IPerson } from 'src/app/interfaces/person';
import { StorageService } from 'src/app/services/storage/storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
	emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
  	error : string = "";
  	person : IPerson = {
		firstName : '',
		lastName : '',
		email : '',
		password : ''
	}

  	constructor(private storageServie : StorageService , private router : Router){

  	}
  	register(){

		const validation = this.person.lastName && this.person.firstName && this.emailPattern.test(this.person.email)
		&& this.person.password.length > 8;

		if(validation) {
			this.storageServie.set({key : environment.WOROLOKEY,value : JSON.stringify(this.person)});
			return this.router.navigate(["/login"]) ;
		}

    	return this.error = "Veuillez renseigner tout les champs svp";
  }
}

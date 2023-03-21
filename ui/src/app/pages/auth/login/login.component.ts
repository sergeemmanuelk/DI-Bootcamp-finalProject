import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IPerson } from 'src/app/interfaces/person';
import { PersonService } from 'src/app/services/storage/person.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  error : string = '';
  person : IPerson = {
    email : '',
    password : ''
  }

  constructor(private PersonService : PersonService , private router : Router) {

  }

  login(){
    const person = this.PersonService.getPerson();

    if(person?.email == this.person.email && person?.password == this?.person.password) {
      return location.href = "/home";
    }

    return (this.error = "Email ou mot de passe incorrect !")
  }
}

import { environment } from 'src/app/environment/dev';
import { StorageService } from './storage.service';
import { IPerson } from "src/app/interfaces/person";
import { Injectable } from '@angular/core';

@Injectable({
  providedIn :'root'
})
export class PersonService {

  Person ?: IPerson;

  constructor(private storageService : StorageService ){
    this.Person = JSON.parse(this.storageService.get(environment.WOROLOKEY) as string);
  }

  logout(){
    this.storageService.delete(environment.WOROLOKEY);
  }

  isConnected() : boolean {
    return !!this.Person;
  }

  getPerson() : IPerson{
   return this.Person as IPerson;
  }
}
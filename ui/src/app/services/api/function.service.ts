import { Injectable } from "@angular/core";
import { HttpService } from "./api.service";
import { url_path } from "src/app/constants/app.constant";
import { IPerson } from "src/app/interfaces/person";
import { IMunicipality } from "src/app/interfaces/municipality";
import { IHealthCenter } from "src/app/interfaces/healthCenter";

@Injectable({
	providedIn : 'root'
})
export class FunctionService {

	constructor(private httpService : HttpService ) {  }

	getPerson() {
		return this.httpService.get(url_path.PERSON_BASE);
	}

	createPerson(person : IPerson) {
	return this.httpService.post({endpoint : url_path.PERSON_BASE,data : person});
	}

	updatePerson(person : IPerson) {
		return this.httpService.put({endpoint : url_path.PERSON_BASE,data : person});
	}

	deletePerson(id : string) {
		return this.httpService.delete(`${url_path.PERSON_BASE}/${id}`);
	}

	/* getMunicipality() {
		return this.httpService.get(url_path.MUNICIPALITY_BASE);
	}

	createMunicipality(municipality : IMunicipality) {
		return this.httpService.post({endpoint : url_path.MUNICIPALITY_BASE,data : municipality});
		}
	
	updateMunicipality(municipality : IMunicipality) {
		return this.httpService.put({endpoint : url_path.MUNICIPALITY_BASE,data : municipality});
	}
	
	deleteMunicipality(id : string) {
		return this.httpService.delete(`${url_path.MUNICIPALITY_BASE}/${id}`);
	}

	createHealthCenter(healthCenter : IHealthCenter) {
		return this.httpService.post({endpoint : url_path.HEALTH_CENTER_BASE,data : healthCenter});
	}
	
	updateHealthCenter(healthCenter : IHealthCenter) {
		return this.httpService.put({endpoint : url_path.HEALTH_CENTER_BASE,data : healthCenter});
	}
	
	getHealthCenter() {
		return this.httpService.get(url_path.HEALTH_CENTER_BASE);
	}
	
	deleteHealthCenter(id : string) {
		return this.httpService.delete(`${url_path.HEALTH_CENTER_BASE}/${id}`);
	} */

}
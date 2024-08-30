import { Component, OnInit } from "@angular/core";
import { BaseListCtl } from "../base-list.component";
import { ServiceLocatorService } from "../service-locator.service";
import { ActivatedRoute } from "@angular/router";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-leadlist",
  templateUrl: "./leadlist.component.html",
  styleUrls: ["./leadlist.component.css"],
})
export class LeadlistComponent extends BaseListCtl implements OnInit {

  public form = {
    error: false,
    message: null,
    preload: {
      leadList: [],
    },
    data: { id: null },

    searchParams: {
      openingDate: "",
      contactName: "",
      date: "",
      statusId: null,
      mobile: "",
    },
    searchMessage: null,
    list: [],
    pageNo: 0,
  };

  constructor(public locator: ServiceLocatorService,public route: ActivatedRoute,private httpClient: HttpClient) {
    super(locator.endpoints.LEAD, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }

  formatDate(event: any) {
    const selectedDate = new Date(event);
    const formattedDate = selectedDate.toISOString().split("T")[0];
    this.form.searchParams.date = formattedDate;
  }

  convertToLocalDate(dateString: string): string {
    const date = new Date(dateString);

    const options: any = { year: "numeric", month: "2-digit", day: "2-digit" };
    return date.toLocaleDateString(undefined, options);
  }

  submit() {
    this.form.pageNo = 0;

    this.search();
  }

  search() {
    this.form.searchMessage = null;

    super.search();
  }

  validateAlphabetInput(event: KeyboardEvent) {
    const str = event.key;
   
    if (!/^[a-zA-Z\s]*$/.test(str)) {
      event.preventDefault();
    }
  }

  validateMobileInput(event: KeyboardEvent) {
    const newValue = (event.target as HTMLInputElement).value + event.key;
    if (!/^[6-9][0-9]{0,9}$/.test(newValue)) {
      event.preventDefault();
    }
  }
}

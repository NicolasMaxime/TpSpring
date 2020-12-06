import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  private _search$ : EventEmitter<number>;
  private _idproc : number;

  constructor() {
    this._search$ = new EventEmitter<number>();
    this._idproc = 0;
  }

  ngOnInit(): void {
  }

  @Input()
  set idproc(value: number) {
    this._idproc = value;
  }

  @Output('search')
  get search$(): EventEmitter<number>{
    return this._search$;
}

  search($event: KeyboardEvent) {
    if ($event.key === "Enter") {
      this._search$.emit(this._idproc);
    }
  }
}

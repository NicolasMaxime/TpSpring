import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Processor} from "../interfaces/processor";
import {defaultIfEmpty, filter} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ProcessorService {

  private _backendUrl : any;

  constructor(private readonly _http: HttpClient) {
    this._backendUrl = {};
    let tmp = `${environment.protocol}://${environment.host}`;
    if (environment.port){
      tmp += `:${environment.port}`;
    }
    Object.keys(environment.endpoint).forEach(x => this._backendUrl[x] = `${tmp}${environment.endpoint[x]}`);
  }

  /**
   * Return HttpHeaders option
   * @private
   */
  private _option() : HttpHeaders{
    return new HttpHeaders(
      {
        'Access-Control-Allow-Origin' : '127.0.0.1',
        'Content-Type': 'application/json'
      })
  }

  fetchall(): Observable<Processor[]>{
    return this._http.get<Processor[]>(this._backendUrl.getAll, {headers: this._option()})
      .pipe(
        filter(_ => !!_),
        defaultIfEmpty([])
      );
  }

  delete(id: number): Observable<void> {
    return this._http.delete<void>(this._backendUrl.deleteOne.replace(':id', String(id), ));
  }

  create(proc: Processor) {
    return this._http.post<Processor>(this._backendUrl.addOne, proc, {headers: this._option()});
  }

  fetch(id: number): Observable<Processor> {
    return this._http.get<Processor>(this._backendUrl.getOne.replace(':id', String(id))).pipe(
      filter(_ => !!_),
      defaultIfEmpty(undefined)
    );
  }

  update(processor: Processor): Observable<Processor> {
    return this._http.put<Processor>(this._backendUrl.addOne, processor, {headers: this._option()})
  }
}

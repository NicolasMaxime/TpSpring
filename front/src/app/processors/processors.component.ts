import { Component, OnInit } from '@angular/core';
import {ProcessorService} from "../shared/service/processor.service";
import {Processor} from "../shared/interfaces/processor";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {AddDialogComponent} from "../shared/dialog/add-dialog/add-dialog.component";
import {filter, map, mergeMap} from "rxjs/operators";
import {Observable} from "rxjs";

@Component({
  selector: 'app-processors',
  templateUrl: './processors.component.html',
  styleUrls: ['./processors.component.css']
})
export class ProcessorsComponent implements OnInit {
  private _processors: Processor[];
  private _dialogRef: MatDialogRef<AddDialogComponent>;
  private _dialogStatus: string;

  constructor(private readonly _processorService: ProcessorService,
              private _matdialog: MatDialog) {
    this._dialogStatus = 'inactive';
  }

  ngOnInit(): void {
    this._processorService.fetchall().subscribe(
      (_: Processor[]) => this._processors = _,
    );
  }

  get processors(): Processor[]{
    return this._processors;
  }

  delete($event: Processor) {
    this._processorService.delete($event.id).subscribe(
      _ => this._processors = this._processors.filter(__ => __.id !== $event.id)
    );
  }

  add(){
      this._dialogStatus = 'active';
      this._dialogRef = this._matdialog.open(AddDialogComponent, {
        width: '500px',
        disableClose: true
      })

    this._dialogRef.afterClosed()
      .pipe(
        filter(_ => !!_),
        map((_ : Processor) =>{
          delete _.id;
          return _;
        }),
        mergeMap(_ => this._add(_)),
        )
      .subscribe(
        (process : Processor[]) => this._processors = process,
        _ => this._dialogStatus = 'inactive',
        () => this._dialogStatus = 'inactive'
    );
  }

  private _add(proc: Processor): Observable<Processor[]> {
    return this._processorService.create(proc).pipe(
      mergeMap(_ => this._processorService.fetchall())
    );
  }

  update($event: Processor) {
  this._dialogRef = this._matdialog.open(AddDialogComponent, {
      width: '500px',
      disableClose: true,
      data: $event
    })
    this._dialogRef.afterClosed()
      .pipe(
        filter(_ => !!_),
        map((_ : Processor) =>{
          delete _.photo;
          return _;
        }),
        mergeMap(_ => this._update(_)),
      )
      .subscribe(
        (process : Processor[]) => this._processors = process,
        _ => this._dialogStatus = 'inactive',
        () => this._dialogStatus = 'inactive'
      );
  }

  private _update(proc: Processor): Observable<Processor[]> {
    return this._processorService.update(proc).pipe(
      mergeMap(_ => this._processorService.fetchall())
    );
  }
}

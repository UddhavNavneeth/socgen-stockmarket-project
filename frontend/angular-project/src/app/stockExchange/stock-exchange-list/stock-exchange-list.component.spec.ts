import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockExchangeListComponent } from './stock-exchange-list.component';

describe('StockExchangeListComponent', () => {
  let component: StockExchangeListComponent;
  let fixture: ComponentFixture<StockExchangeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockExchangeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockExchangeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

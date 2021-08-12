import { Company } from "./Company";
import { StockExchange } from "./StockExchange";

export interface IpoDetail {
    id?: number,
    pricePerShare: number,
    totalNumberOfShares: number,
    remarks: string,
    openDateTime: Date,
    company: Company,
    stockExchange: StockExchange
}
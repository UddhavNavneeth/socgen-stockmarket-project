import { Address } from "../models/Address";

export interface StockExchange {
    id?: number,
    name: string,
    brief: string,
    remarks: string,
    address: Address
}
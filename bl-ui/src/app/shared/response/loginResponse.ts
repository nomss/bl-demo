export interface LoginResponse {
    id: number
    username: string
    locationDTO: Array<Location>
}

export interface Location {
    id: number
    airportName: string
    airportCode: string
}
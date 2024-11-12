import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateFn, Data,
  GuardResult,
  MaybeAsync, Router,
  RouterStateSnapshot
} from '@angular/router';
import {Injectable} from '@angular/core';
import {AuthService} from '../services/auth.service';

@Injectable()
export class AuthorisationGuard  {

  constructor(private  authService :AuthService, private router :Router ) {
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {

    if  (this.authService.isAuthenticated) {
      let requiredRoles  =  route.data ['roles'] ;
      let userRoles : string[]  =  this.authService.roles ;
      // @ts-ignore
      for (let role :string of userRoles){
        if (requiredRoles.includes(role))
        {
          return  true;
        }
      }
      return  false ;
    }else {
      this.router.navigateByUrl("/login") ;
      return  false ;
    }
  }


}

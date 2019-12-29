import React from "react";
import {CssBaseline} from "@material-ui/core";
import TopBar from '../rootPartial/RootComponentContainer'

const Header = (props: any) => {
   return (
      <React.Fragment>
         <CssBaseline />
         <TopBar children={props.children} />
      </React.Fragment>
)};

export default Header
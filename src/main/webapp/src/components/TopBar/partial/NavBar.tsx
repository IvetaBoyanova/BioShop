import React from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { Link } from "react-router-dom";

const NavStyle: React.CSSProperties = {
   textAlign: 'center'
};

const ListStyle = {
   width: 'fit-content',
   display: 'inline-block'
};

const ListItemStyle = {
   paddingLeft: '20px',
   paddingRight: '20px'
};

function NavBar(props) {
   return (
      <List style={NavStyle} component="nav" dense>
         <ListItem style={ListStyle} button component={Link} to="/">
            <ListItemText style={ListItemStyle} inset>Home</ListItemText>
         </ListItem>
         <ListItem style={ListStyle} button component={Link} to="/shop">
            <ListItemText style={ListItemStyle} inset>Shop</ListItemText>
         </ListItem>
         <ListItem style={ListStyle} button component={Link} to="/about-us">
            <ListItemText style={ListItemStyle} inset>About Us</ListItemText>
         </ListItem>
         <ListItem style={ListStyle} button component={Link} to="/contacts">
            <ListItemText style={ListItemStyle} inset>Contacts</ListItemText>
         </ListItem>
      </List>
   )
}

export default NavBar;
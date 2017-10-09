/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package dimayor.controller;


import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Date;
import java.util.List;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;

import dimayor.dao.TeamDAO;
import dimayor.entity.Team;



/** The Echo API which Endpoints will be exposing. */
// [START echo_api_annotation]
@Api(
    name = "dimayor",
    version = "v1",
    namespace =
      @ApiNamespace(
        ownerDomain = "dimayor.controller",
        ownerName = "dimayor.controller",
        packagePath = ""
      ),
    // [START_EXCLUDE]
    issuers = {
      @ApiIssuer(
        name = "firebase",
        issuer = "https://securetoken.google.com/cloud-computing-scheduledoc",
        jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
    }
    // [END_EXCLUDE]
    )
// [END echo_api_annotation]
public class DimayorController {
  /**
   * Echoes the received message back. If n is a non-negative integer, the message is copied that
   * many times in the returned message.
   *
   * Note that name is specified and will override the default name of "{class name}.{method
   * name}". For example, the default is "echo.echo".
   *
   * Note that httpMethod is not specified. This will default to a reasonable HTTP method
   * depending on the API method name. In this case, the HTTP method will default to POST.
   */
   
  @ApiMethod(name = "crearEquipo")
  public void newTeam(Team nuevo) {
	  
    TeamDAO td=new TeamDAO();
    td.addTeam(nuevo);
	  
  }
	
  @ApiMethod(name = "eliminarEquipo")
  public void deleteTeam(Team nuevo) {
	  
	  TeamDAO td=new TeamDAO();
	  td.deleteTeam(nuevo);
    
  }
	
  @ApiMethod(name = "actualizarEquipo")
  public void updateTeam(Team nuevo) {
	  
	  TeamDAO td=new TeamDAO();
	  td.editTeam(nuevo);
  }
	
  @ApiMethod(name = "listarEquipos")
  public List<Team> getTeams() {
	  
	  TeamDAO td=new TeamDAO();  
	  return td.getAllTeams();
    
  }
  
 
	
  

}
